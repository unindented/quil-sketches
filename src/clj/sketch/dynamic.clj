(ns sketch.dynamic
  (:require [quil.core :refer :all]
            [thi.ng.color.core :as col]
            [thi.ng.color.presets.categories :as colcat]))

(defn w
  ([] (w 1.0))
  ([value] (* (width) value)))

(defn h
  ([] (h 1.0))
  ([value] (* (height) value)))

(defn rand-color []
  (colcat/cat20b (int (random 20))))

(defn draw-circle []
  (fill 255 (random 255))
  (stroke 255 (random 255))
  (stroke-weight (random (w 0.01)))

  (let [diam (random (w 0.02) (w 0.2))
        x    (random (w))
        y    (random (h))]
    (ellipse x y diam diam)))

(defn setup []
  (color-mode :rgb))

(defn draw [state]
  (background (rand-color))

  (dotimes [n 32]
    (draw-circle)))
