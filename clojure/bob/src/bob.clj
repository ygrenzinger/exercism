 (ns bob)

 (defn response-for [sentence]
   (condp re-matches sentence
     #"\s*" "Fine. Be that way!"
     #"[^a-z-A-Z]+(?<!\?)$" "Whatever."
     #"[^a-z-A-Z]+?$" "Sure."
     #"^[^a-z]+$" "Whoa, chill out!"
     #"^(.*)\?$" "Sure."
     "Whatever."))
