let menu = document.getElementById("sticky");
let bandera = false;
let stickPoint = getDistancia();

function getDistancia() {
  let topDist = menu.offsetTop;
  return topDist;
}

const menuSticky = function(e) {

    let distancia = getDistancia() - window.pageYOffset;
    let offset = window.pageYOffset;
    
    // console.log( `stickPoint = ${stickPoint}, distancia = ${distancia}, offset = ${offset}, bandera = ${bandera}` );
    
    if ( (distancia <= 0) && !bandera) {
      menu.classList.add("menu-fixed")
      bandera = true;
    } 
    
    else if (bandera && (offset <= stickPoint)){
      menu.classList.remove("menu-fixed")
      bandera = false;
    }

  }

window.onscroll = function(e){
    menuSticky(e);
};