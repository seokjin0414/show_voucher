document.addEventListener('DOMContentLoaded', function () {
  /* VH */
  
  vh()
  window.addEventListener('resize', vh)
  

  /* Zoom */
  
  zoom()
  window.addEventListener('resize', zoom)
  

  /* Viewport */
  if (navigator.userAgent.match(/iP(hone|od|ad)/)) {
    document.getElementsByName('viewport')[0].setAttribute('content', 'width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0')
  } else {
    document.getElementsByName('viewport')[0].setAttribute('content', 'width=device-width, initial-scale=1.0')
  }

  /* isMobile */
  if (navigator.userAgent.match(/Android|Mobile|iP(hone|od|ad)|BlackBerry|IEMobile|Kindle|NetFront|Silk-Accelerated|(hpw|web)OS|Fennec|Minimo|Opera M(obi|ini)|Blazer|Dolfin|Dolphin|Skyfire|Zune/)) {
    document.querySelector('body').classList.add('is-mobile')
  } else {
    document.querySelector('body').classList.add('is-pc')
  }
})

/* VH */

function vh() {
  let vh = window.innerHeight * 0.001
  document.querySelector(':root').setAttribute('style', '--vh:' + vh + 'px;')
}

/* Zoom */

function zoom() {
  let clientWidth = document.documentElement.clientWidth
  let zoom = 1
  if (clientWidth < 450) {
    zoom = (clientWidth / 450)
  } else {
    zoom = 1
  }
  document.querySelector('body').style.zoom = zoom
}

// window.addEventListener('load', function (){ 
//   const element = document.querySelector('.container')
//   const backgroundColor = window.getComputedStyle(element).backgroundColor
//   document.querySelector('body').style.backgroundColor=backgroundColor
// })