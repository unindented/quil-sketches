# Quil Sketches

Some [Quil](http://quil.info/) sketches.


## Usage

### REPL

Fire up a REPL with:

```
$ lein repl
```

Then use the core namespace:

```clj
(use 'sketch.core)
```

You can reload the dynamic namespace with:

```clj
(refresh)
```

### Publish

Change the `project.clj` to load `sketch.run`, and run:

```
$ lein run
```


## Linting

Check linting with:

```
$ lein cljfmt check
```

Fix linting issues with:

```
$ lein cljfmt fix
```


## Meta

* Code: `git clone git://github.com/unindented/quil-sketches.git`
* Home: <https://unindented.github.io/quil-sketches/>


## Contributors

* Daniel Perez Alvarez ([unindented@gmail.com](mailto:unindented@gmail.com))


## License

Copyright (c) 2017 Daniel Perez Alvarez ([unindented.org](https://unindented.org/)). This is free software, and may be redistributed under the terms specified in the LICENSE file.
