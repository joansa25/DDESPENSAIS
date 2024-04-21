
const sidebar = document.getElementById('sidebar');
const sidebarToggle = document.getElementById('sidebarToggle');

sidebarToggle.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});
    function regresarMenuPrincipal() {
        // Redirigir al usuario a MENU PRINCIPAL
        window.location.href = "MENUPRINCIPAL.html";
    }
    function cerrarSesion() {
        // Redirigir al usuario a la página index
        window.location.href = "../../../index.jsp";
    }