<script setup>
import { ref, onMounted } from 'vue';

const quantas = ref([]);
const loading = ref(false);
const error = ref(null);

const fetchquantas = async () => {
  loading.value = true;
  error.value = null;

  try {
    const res = await fetch("http://localhost:8080/show");

    if (!res.ok) {
      throw new Error("Failed to fetch quanta");
    }

    quantas.value = await res.json();
  } catch (err) {
    error.value = err.message;
    console.error(err);
  } finally {
    loading.value = false;
  }
};

onMounted(fetchquantas);
</script>

<template>
  <div class="min-h-screen bg-gray-100 py-10 px-4">
    
    <!-- Container -->
    <div class="max-w-6xl mx-auto bg-white shadow-xl rounded-2xl overflow-hidden">
      
      <!-- Header -->
      <div class="bg-linear-to-r from-indigo-600 to-blue-500 px-6 py-5">
        <h1 class="text-3xl font-bold text-white">
          All Quanta Show
        </h1>
      </div>

      <!-- Loading -->
      <div v-if="loading" class="p-6 text-center">
        <p class="text-lg font-medium text-blue-600 animate-pulse">
          Loading data...
        </p>
      </div>

      <!-- Error -->
      <div v-else-if="error" class="p-6">
        <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded-lg">
          {{ error }}
        </div>
      </div>

      <!-- Empty State -->
      <div
        v-else-if="!quantas.length"
        class="p-10 text-center text-gray-500"
      >
        No data found.
      </div>

      <!-- Table -->
      <div v-else class="overflow-x-auto">
        <table class="w-full text-left border-collapse">
          
          <!-- Table Head -->
          <thead class="bg-gray-800 text-white">
            <tr>
              <th class="px-6 py-4 text-sm font-semibold uppercase tracking-wide">
                Name
              </th>
              <th class="px-6 py-4 text-sm font-semibold uppercase tracking-wide">
                Quanta
              </th>
              <th class="px-6 py-4 text-sm font-semibold uppercase tracking-wide">
                Email
              </th>
            </tr>
          </thead>

          <!-- Table Body -->
          <tbody>
            <tr
              v-for="quant in quantas"
              :key="quant.id"
              class="border-b hover:bg-blue-50 transition duration-200"
            >
              <td class="px-6 py-4 text-gray-800">
                {{ quant.name }}
              </td>

              <td class="px-6 py-4">
                <span
                  class="bg-indigo-100 text-indigo-700 px-3 py-1 rounded-full text-sm font-semibold"
                >
                  {{ quant.quanta }}
                </span>
              </td>

              <td class="px-6 py-4 text-gray-600">
                {{ quant.email }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>