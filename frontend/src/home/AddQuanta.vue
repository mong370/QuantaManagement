<script setup>
import { ref } from 'vue'

const name = ref('')
const quanta = ref('')
const email = ref('')

const loading = ref(false)
const message = ref("")
const error = ref(null)

const addData = async () => {
  loading.value = true;
  message.value = "";
  error.value = null;

  try {
    const response = await fetch('http://localhost:8080/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        name: name.value,
        quanta: quanta.value,
        email: email.value
      })
    });

    if (!response.ok) {
      throw new Error("Failed to save quanta");
    }

    message.value = "Quanta info added successfully!";

    // reset form
    name.value = "";
    quanta.value = "";
    email.value = "";

  } catch (err) {
    error.value = err.message;
  } finally {
    loading.value = false;
  }
}
</script>

<template>
  <div class="min-h-screen m-0 bg-linear-to-br from-indigo-100 via-blue-50 to-purple-100 flex items-center justify-center">

    <!-- Card -->
    <div class="w-full max-w-lg bg-white rounded-3xl shadow-2xl overflow-hidden">

      <!-- Header -->
      <div class="bg-linear-to-r from-indigo-600 to-blue-500 px-8 py-6">
        <h1 class="text-3xl font-bold text-white">
          Add Quanta Information
        </h1>

        <p class="text-blue-100 mt-2">
          Store quanta details securely
        </p>
      </div>

      <!-- Form -->
      <form
        @submit.prevent="addData"
        class="p-8 space-y-6"
      >

        <!-- Success Message -->
        <div
          v-if="message"
          class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded-xl"
        >
          {{ message }}
        </div>

        <!-- Error Message -->
        <div
          v-if="error"
          class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded-xl"
        >
          {{ error }}
        </div>

        <!-- Name -->
        <div>
          <label class="block text-gray-700 font-semibold mb-2">
            Full Name
          </label>

          <input
            type="text"
            placeholder="Enter full name"
            v-model="name"
            class="w-full px-4 py-3 border border-gray-300 rounded-xl focus:ring-4 focus:ring-indigo-200 focus:border-indigo-500 outline-none transition"
          >
        </div>

        <!-- Quanta -->
        <div>
          <label class="block text-gray-700 font-semibold mb-2">
            Quanta
          </label>

          <input
            type="number"
            placeholder="Enter quanta value"
            v-model="quanta"
            class="w-full px-4 py-3 border border-gray-300 rounded-xl focus:ring-4 focus:ring-indigo-200 focus:border-indigo-500 outline-none transition"
          >
        </div>

        <!-- Email -->
        <div>
          <label class="block text-gray-700 font-semibold mb-2">
            Email Address
          </label>

          <input
            type="email"
            placeholder="Enter email address"
            v-model="email"
            class="w-full px-4 py-3 border border-gray-300 rounded-xl focus:ring-4 focus:ring-indigo-200 focus:border-indigo-500 outline-none transition"
          >
        </div>

        <!-- Button -->
        <button
          type="submit"
          :disabled="loading"
          class="w-full bg-linear-to-r from-indigo-600 to-blue-500 hover:from-indigo-700 hover:to-blue-600 text-white font-bold py-3 rounded-xl shadow-lg transition duration-300 disabled:opacity-50"
        >
          <span v-if="loading">Saving...</span>
          <span v-else>Add Quanta</span>
        </button>
      </form>
    </div>
  </div>
</template>