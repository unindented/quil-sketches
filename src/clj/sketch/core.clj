(ns sketch.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [sketch.dynamic :as dynamic]))

(defn dynamic-setup []
  (dynamic/setup))

(defn dynamic-draw [state]
  (q/no-loop)
  (dynamic/draw state)
  (q/save "docs/sketches/scratch.png"))

(q/defsketch sketch
  :title "Sketch"
  :size [512 512]
  :setup dynamic-setup
  :draw dynamic-draw
  :middleware [m/fun-mode]
  :features [:keep-on-top])

(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop sketch))
