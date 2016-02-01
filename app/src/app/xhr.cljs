(ns app.xhr
  (:require [cljs.reader :as reader]
            [goog.events :as events])
  (:import [goog.net XhrIo]
           goog.net.EventType
           [goog.events EventType]))

(def ^:private meths
  {:get    "GET"
   :put    "PUT"
   :post   "POST"
   :delete "DELETE"})

(defn make-xhr
  [{:keys [method url data on-complete]}]
  (let [url (str "http://localhost:3141/api/" url)
        xhr (XhrIo.)]
    (events/listen xhr goog.net.EventType.COMPLETE
                   (fn [e]
                     (on-complete (.getResponseText xhr))))
    (. xhr
       (send url (get meths method) (when data (pr-str data))
             #js {"Content-Type" "application/json"}))))
