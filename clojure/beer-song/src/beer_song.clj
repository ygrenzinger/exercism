 (ns beer-song)

 (defn verse
   [nb]
   (if (= 0 nb)
     (str "No more bottles of beer on the wall, no more bottles of beer.\n"
          "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
     (let [down-bottles (condp = nb
                                     2 "1 bottle of beer on the wall.\n"
                                     1 "no more bottles of beer on the wall.\n"
                                     (str (dec nb) " bottles of beer on the wall.\n"))
           remaining-bottles (str nb (if (= 1 nb) " bottle" " bottles"))]
       (str remaining-bottles " of beer on the wall, " remaining-bottles " of beer.\n"
            "Take " (if (= 1 nb) "it" "one") " down and pass it around, " down-bottles))))

 (defn sing
   ([start] (sing start 0))
   ([start end]
     (if (= start end)
       (verse start)
       (str (verse start)
            "\n"
            (sing (dec start) end)))))