(ns abc.routes.home
  (:require [abc.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [abc.db.core :as db]
            [bouncer.core :as b]
            [bouncer.validators :as v]))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/about" [] (about-page)))

