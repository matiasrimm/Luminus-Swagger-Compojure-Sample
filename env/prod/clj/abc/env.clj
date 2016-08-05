(ns abc.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[abc started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[abc has shut down successfully]=-"))
   :middleware identity})
