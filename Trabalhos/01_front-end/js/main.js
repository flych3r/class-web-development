var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}

dishOfDay();
function dishOfDay() {
    var d = (new Date()).getDay();
    var i;
    var j = 0;
    var v = [49, 77, 26, 51, 80, 58, 17, 32, 29, 38, 27, 18, 14, 25, 27, 27, 23, 57, 95, 42]
    var pratos = document.getElementsByClassName("images");
    var valores = document.getElementsByClassName("text");
    if(d == 0 || d == 5)
    {
        for(i = 1; i <= 5; i++) {
            pratos[j].src = "images/" + i + ".jpg";
            valores[j].append(v[i]);
            j++;
        }
    }
    if(d == 2 || d == 4)
    {
        for(i = 5; i <= 10; i++) {
            pratos[j].src = "images/" + i + ".jpg";
            valores[j].append(v[i]);
            j++;
        }
    }
    if(d == 3 || d == 6)
    {
        for(i = 11; i <= 15; i++) {
            pratos[j].src = "images/" + i + ".jpg";
            valores[j].append(v[i]);
            j++;
        }
    }
    if(d == 1)
    {
        for(i = 16; i <= 20; i++) {
            pratos[j].src = "images/" + i + ".jpg";
            valores[j].append(v[i]);
            j++;
        }
    }
}
