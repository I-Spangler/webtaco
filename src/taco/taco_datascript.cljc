(ns taco.taco-datascript
  (:require [datascript.core :as d]
            [clojure.string :as string]))

(def taco-attributes 
  [:id
  :nome
  :umidade
  :energia-kcal
  :energia-kj
  :proteina
  :lipideos
  :colesterol
  :carboidrato
  :fibra
  :cinzas
  :calcio
  :magnesio])

(def taco-attributes2 
  [:id
    :manganes
    :fosforo
    :ferro
    :sodio
    :potassio
    :cobre
    :zinco
    :retinol
    :re 
    :rae 
    :tiamina 
    :riboflavina 
    :piridoxina 
    :niacina 
    :vitamina-c])

(def taco-attributes3
  [:id
  :nome 
  :Saturados 
  :monoinsaturados
  :poliinsaturados
  :12-0
  :14-0
  :16-0
  :18-0
  :20-0
  :22-0
  :24-0
   ])

(def taco-attributes4
  [:id
  :14-1
  :16-1
  :18-1
  :20-1
  :18-2n-6
  :18-3n-3
  :20-4
  :20-5
  :22-5
  :22-6
  :18-1t
  :18-2t
   ])

(def taco-attributes5
  [:id
  :nome
  :triptofano
  :treonina
  :isoleucina
  :leucina
  :lisina
  :metionina
  :cistina
  :fenilalanina
  :tirosina
   ])

(defn taco-insert [lines attrib]
  (for [line lines] 
    (let [values (map string/trim (string/split line #","))]
      (zipmap attrib values))))

(defn load-taco-data [db-file attrib] (taco-insert (string/split-lines (slurp db-file) attrib)))

;;(def nutrientes {})

(def schema {:id {:db/unique :db.unique/identity}})

(def conn (d/create-conn schema))

(d/transact! conn (load-taco-data "taco-db-nutrientes.csv" taco-attributes))
(d/transact! conn (load-taco-data "taco-db-nutrientes-2.csv" taco-attributes2))
(d/transact! conn (load-taco-data "taco-db-graxos.csv" taco-attributes3))
(d/transact! conn (load-taco-data "taco-db-graxos-2.csv" taco-attributes4))
(d/transact! conn (load-taco-data "taco-db-aminoacidos.csv" taco-attributes5))
(d/transact! conn (load-taco-data "taco-db-aminoacidos-2.csv" taco-attributes6))
