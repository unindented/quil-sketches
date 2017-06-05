(ns sketch.run
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [image-resizer.core :as r]
            [image-resizer.format :as f]
            [clojure.java.io :as io]
            [clojure.data.codec.base64 :as b64]
            [sketch.dynamic :as dynamic])
  (:gen-class))

(defn date []
  (.format (java.text.SimpleDateFormat. "yyyy-MM-dd") (new java.util.Date)))

(defn resize-image [src dst size]
  (f/as-file (r/resize (io/file src) size size) dst :verbatim))

(defn encode-image [src dst size ext]
  (with-open [in  (f/as-stream (r/resize (io/file src) size size) ext)
              out (io/output-stream dst)]
    (b64/encoding-transfer in out)))

(defn dynamic-setup []
  (dynamic/setup))

(defn dynamic-draw [state]
  (q/no-loop)

  (dotimes [n 10]
    (dynamic/draw state)

    (let [base-path    (str "docs/sketches/" (date) "/" n)
          large-image  (str base-path "_large.png")
          medium-image (str base-path "_medium.png")
          small-image  (str base-path "_small.png")
          tiny-image   (str base-path "_tiny.b64")]
      (q/save large-image)
      (resize-image large-image medium-image 512)
      (resize-image medium-image small-image 256)
      (encode-image small-image tiny-image 8 "png")))

  (q/exit))

(defn -main [& args]
  (q/sketch
   :title "Sketch"
   :size [4096 4096]
   :setup dynamic-setup
   :draw dynamic-draw
   :middleware [m/fun-mode]
   :features [:exit-on-close]))
