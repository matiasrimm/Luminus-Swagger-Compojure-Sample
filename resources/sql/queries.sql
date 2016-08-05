-- :name create-message :! :n
-- :doc creates a new message
INSERT INTO guestbook
(name, message, timestamp)
VALUES (:name, :message, :timestamp)

-- :name get-messages :? :*
-- :doc selects all  messages
SELECT * from guestbook

-- :name get-message :? :1
-- :doc selects message with given id
SELECT * from guestbook
WHERE id = :id

-- :name delete-message :! :1
-- :doc selects message with given id
DELETE FROM guestbook
WHERE id = :id

-- :name delete-messages :! :n
-- :doc deletes all messages
DELETE FROM guestbook

--:name update-messages :! :n
-- :doc updates all messages
UPDATE guestbook
SET name = :name,
message = :message,
timestamp = :timestamp

--:name update-message :! :1
--:doc updates message with given id
UPDATE guestbook
SET name = :name, message = :message, timestamp = :timestamp
WHERE id = :message_id
