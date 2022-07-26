<template>
  <div class="sidebar">
    <img src="../../assets/logo_vertical.png" />
  </div>
</template>

<script>
export default {};
</script>

<style>
/* Rectangle 1 */
.sidebar {
  height: 100%;
  width: 140px;
  position: fixed;
  top: 0;
  left: 0;
  overflow-x: hidden;
  padding-top: 0;
  background: #ffffff;
  box-shadow: 5px 1px 40px 10px rgba(238, 238, 238, 0.4);
}

.sidebar a {
  display: block;
  text-align: center;
  transition: all 0.3s ease;
  color: white;
}

.sidebar a:hover {
  background-color: #6667ab;
}

.active {
  background: #d0d1ff;
}
</style>
