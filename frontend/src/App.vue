<script setup>
</script>

<template>
  <div class="min-h-screen bg-gray-100">

    <!-- Navbar -->
    <nav class="bg-linear-to-r from-indigo-600 to-blue-500 shadow-lg">
      
      <div class="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
        
        <!-- Logo -->
        <h2 class="text-2xl font-bold text-white tracking-wide flex gap-2">
          <img src="https://files.quantummethod.org.bd/resize/30/-/media/image/static_content/homepage_menu_logo_20240624.png">
          Quanta
        </h2>

        <!-- Menu -->
        <ul class="flex items-center gap-6 text-white font-medium">

          <li>
            <RouterLink to="/add" v-slot="{ isActive }">
              <span
                :class="[
                  'transition duration-200 hover:text-yellow-300',
                  isActive ? 'text-yellow-300 font-bold border-b-2 border-yellow-300 pb-1' : ''
                ]"
              >
                Add
              </span>
            </RouterLink>
          </li>

          <li>
            <RouterLink to="/show" v-slot="{ isActive }">
              <span
                :class="[
                  'transition duration-200 hover:text-yellow-300',
                  isActive ? 'text-yellow-300 font-bold border-b-2 border-yellow-300 pb-1' : ''
                ]"
              >
                Show
              </span>
            </RouterLink>
          </li>

          <li>
            <RouterLink to="/custom" v-slot="{ isActive }">
              <span
                :class="[
                  'transition duration-200 hover:text-yellow-300',
                  isActive ? 'text-yellow-300 font-bold border-b-2 border-yellow-300 pb-1' : ''
                ]"
              >
                Customize
              </span>
            </RouterLink>
          </li>

        </ul>
      </div>
    </nav>

    <!-- Page Content -->
    <main>
      <RouterView />
    </main>

  </div>
</template>