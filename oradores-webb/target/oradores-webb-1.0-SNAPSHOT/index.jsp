<!DOCTYPE html>
<html lang="es-ar" data-bs-theme="light">
	<head>
            <%@include file="head.jsp" %>
            <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Oradores</title>
	</head>
	
	<body>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>	
            
              <div class="card mx-auto mt-5" style="width: 40rem;">
      <img src="img/orador.jpg" class="card-img-top" alt="...">
      <div class="card-body">
          <p class="card-text">Conviértete en un orador excepcional y comparte tus conocimientos con el mundo. Inscríbete para dar una charla y empieza a inspirar a otros con tus ideas. Descubre cómo desarrollar tus habilidades de oratoria y comunicación para impactar positivamente en tu audiencia. ¡Únete a nosotros y conviértete en un líder de opinión!</p>
      </div>
  </div>


    <script async src="https://cdn.jsdelivr.net/npm/es-module-shims@1/dist/es-module-shims.min.js" crossorigin="anonymous"></script>
    <script type="importmap">
    {
      "imports": {
        "@popperjs/core": "https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/esm/popper.min.js",
        "bootstrap": "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.esm.min.js"
      }
    }
    </script>
    <script type="module">
      import * as bootstrap from 'bootstrap'

      new bootstrap.Popover(document.getElementById('popoverButton'))
    </script>
  </body>
            <%@include file="footer.jsp" %>
	</body>	
</html>