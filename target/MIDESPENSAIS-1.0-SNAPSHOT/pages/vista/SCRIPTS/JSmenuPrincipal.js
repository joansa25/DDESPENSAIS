
const sidebar = document.getElementById('sidebar');
const sidebarToggle = document.getElementById('sidebarToggle');

sidebarToggle.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});

    function cerrarSesion() {
        // Redirigir al usuario a la página index
        window.location.href = "../../../index.jsp";
    }
    
        function tomarPedido() {
        // Redirigir al usuario a la página de tomar pedido
        window.location.href = "TomarPedido.html";
    }

    function facturar() {
        // Redirigir al usuario a la página de facturación
        window.location.href = "FacturarPedido.html";
    }