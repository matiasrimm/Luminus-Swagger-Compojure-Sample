(ns abc.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [schema.core :as s]
            [abc.db.core :as db]))

;; Schemas
;; Not Able to define Timestamp when post/put so multiple schemas

(s/defschema Message
  {:id s/Int
   :name s/Str
   :message s/Str
   :timestamp java.sql.Timestamp
   })

(s/defschema MessageNoTimestamp
  {:id s/Int
   :name s/Str
   :message s/Str
   :timestamp s/Str
   })

;; Service

(defapi service-routes
  {:swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "Test API"
                           :description "Test Services"}}}}
  (context "/api/v1" []
    :tags ["Testing in this testing testset"]

    (POST "/messages" []
          :return Long
          :body-params [message :- MessageNoTimestamp]
          :summary "creates a new message"
          (ok (db/create-message message)))

    (GET "/messages" []
         :return [Message]
         :summary "returns all messages"
         (ok (db/get-messages)))
    
    (GET "/messages/:id" []
         :return Message
         :path-params [id :- Long]
         :summary "returns message from a given id"
         (ok (db/get-message {:id id})))

    (PUT "/messages" []
         :return Long
         :body-params [message :- MessageNoTimestamp]
         :summary "updates all messages"
         (ok (db/update-messages message)))

    (PUT "/messages/:message_id" []
         :return Long
         :path-params [message_id :- Long]
         :body-params [message :- MessageNoTimestamp]
         :summary "updates message from a given id"
         ;; conj path_params and body_params
         (ok (db/update-message (conj message {:message_id message_id})  )))

    (DELETE "/messages" []
            :return Long
            :summary "deletes all messages"
            (ok (db/delete-messages)))

    (DELETE "/messages/:id" []
            :return Long
            :path-params [id :- Long]
            :summary "deletes messages from a given id"
            (ok (db/delete-message {:id id})))

 ))
