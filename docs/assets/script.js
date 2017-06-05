if (!('IntersectionObserver' in window)) {
  const polyfill = document.createElement('script')
  polyfill.src = 'https://unpkg.com/intersection-observer'
  polyfill.onload = initialize
  document.head.appendChild(polyfill)
} else {
  initialize()
}

function initialize () {
  const imgs = document.querySelectorAll('.sketch-image')
  observe(imgs, (img) => {
    img.srcset = supplant(img.dataset.srcset, img.dataset)
    img.classList.add('sketch-image--loaded')
  })
}

function observe (elems, action) {
  const observer = new IntersectionObserver((changes) => {
    changes.forEach((change) => {
      if (change.intersectionRatio > 0) {
        action(change.target)
        observer.unobserve(change.target)
      }
    })
  })
  elems.forEach((elem) => { observer.observe(elem) })
}

function supplant (str, obj) {
  return str.replace(/\{\s*([^{}]+?)\s*\}/g, (str, key) => obj[key])
}
