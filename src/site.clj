(def site-name "AC")

(def about-post (parse-org "src/posts/about.org"))

(defn page
  [title content]
  [:html
   [:head
    [:title (str site-name " - " title)]
    [:link {:rel  "stylesheet"
            :type "text/css"
            :href "https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"}]]
   [:body content]])

(defn post-content
  [{:keys [title content]}]
  [:h1 {:class "text-lg bg-red-200 p-6"} [:i title]
   [:div {:class "lg:container p-6 lg:mx-auto bg-gray-200"}
    [:div content]]])


(def-asset home-page
  {:path "/index.html"
   :type :html
   :data (page "Sur moi"
               [:div {:class "mx-auto sm:container sm:max-w-sm"}
                [:div {:class "text-center"}
                 [:h1 {:class "text-xl"} "Alex Chojnacki"]
                 [:div {:class "text-gray-500"}
                  [:p "Machine Learning Engineer"]
                  [:p {:class "text-gray-500 font-mono"} "{my first name}writesprograms@gmail.com"]]
                 [:div {:class "text-lg p-2 text-justify font-sans-serif"} (:content about-post)]
                 [:div {:class "text-center align-bottom"}
                  [:a {:href "https://github.com/the-alex"}
                   [:i {:class "text-blue-500 hover:bg-blue-100"
                        :style {:box-shadow "inset 0 -0.125em 0 0 #fff, inset 0 -0.375em 0 0 rgba(219, 234, 254, 0.4);"}}
                    "I can help, but you'll need to be specific."]]]]])})

(comment
  (require '[clj-org.org :as org])
  (org/parse-org (slurp "./src/posts/about.org")))
