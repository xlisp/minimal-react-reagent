Search the text IMPORTANT to see where you must care about.

See `src/App.js`, `src/foo/core.cljs`, `public/index.html`.

Hot-reload for both JavaScript and ClojureScript are available at development.

# For Dev

```
npx shadow-cljs watch app
# or C-c M-j in Emacs Cider

yarn start
```

# For Dist

```
# YOU MUST RUN THIS BUILD FIRST!!!!!!
# yarn build will copy all assets to build directory.
npx shadow-cljs release app
yarn build
```
