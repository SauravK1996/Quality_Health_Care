<footer id="main-footer" class="bg-dark">
  <div class="container">
    <div class="row">
      <div class="col text-center text-primary py-2">
        <p>Copyright &copy; <span id="year"></span> Quality Health Care</p>
      </div>
    </div>
  </div>
</footer>
  
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
  integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
  crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
   integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
   crossorigin="anonymous"></script>

 <script>
    // Get the current year for the copyright
    $('#year').text(new Date().getFullYear());

    //Init ScrollSpy
    $('body').scrollspy({target: '#main-nav'});

    // Smooth Scrolling
    $('#main-nav a').on('click', function(e){
      // Check for a hash value
      if(this.hash !== ""){
        // Prevent default behavior
        e.preventDefault();

        // Store hash
        const hash = this.hash;

        // Animate smooth scroll
        $('html, body').animate({
          scrollTop: $(hash).offset().top
        },800, function(){
          // Add hash to URL after scroll
          window.location.hash = hash;
        });
      }
    });
 </script>