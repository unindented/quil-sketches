(defproject sketch "1.0.0-SNAPSHOT"
  :description "Quil sketches."
  :url "https://github.com/unindented/quil-sketches"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}

  :pom-addition [:developers [:developer
                              [:name "Daniel Perez Alvarez"]
                              [:email "unindented@gmail.com"]]]

  :scm {:name "git"
        :url "https://github.com/unindented/quil-sketches"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [image-resizer "0.1.9"]
                 [quil "2.6.0"]
                 [thi.ng/color "1.2.0"]]

  :profiles {:dev {:plugins [[lein-cljfmt "0.5.6"]]}}

  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]

  ; REPL options:
  ;:jvm-opts ["-Xms1024m" "-Xmx1024m"]
  ;:aot [sketch.dynamic])

  ; Run options:
  :jvm-opts ["-Xms2048m" "-Xmx2048m"]
  :aot [sketch.dynamic sketch.run]
  :main sketch.run)
