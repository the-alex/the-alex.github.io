(def site-name "AC")

(def posts
  (map parse-org ["src/posts/about.org"]))

(comment
  (map parse-org ["posts/about.org"]))


(def-asset global-style
  {:path "/css/global.css"
   :type :css
   :data [:body {:background-color :cyan}]})

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
  [:div {:class "lg:container lg:mx-auto bg-gray-200"}
   [:h2 {:class "text-lg"} "Title: " title]
   [:div content]])

(def-asset blog-page
  {:path "/blog/index.html"
   :type :html
   :data (page "de Moi"
               [:div {:class "flex:center items-center align-middle bg-white rounded-lg p-6"}
                [:div {:class "text-center"}
                 [:h2 {:class "text-lg p-4"} "Alex Chojnacki's Blog"]
                 [:div {:class "lg:container lg:mx-auto bg-gray-200"}
                  [:div {:class "text-blue-500 p-4"} "Yes, this is a blog."]
                  (for [pc posts] (post-content pc))]]])})

(def-asset home-page
  {:path "/index.html"
   :type :html
   :data (page "Sur Moi"
               [:div {:class "flex:center items-center align-middle bg-white rounded-lg p-6"}
                [:div {:class "text-center"}
                 [:h2 {:class "text-lg"} "about Alex Chojnacki"]
                 [:div {:class "text-blue-500 p-1"} "Machine Learning Engineer"]
                 [:div {:class "text-gray-500 font-mono p-1"} "{my first name}writesprograms@gmail.com"]
                 [:a {:href "https://github.com/the-alex"}
                  [:div {:class "text-center align-bottom"}
                   [:i {:class "text-gray-500"} "I can help, but you'll need to be specific."]]]
                 [:a {:href (asset-path blog-page)}
                  [:i {:class "text-gray-500"} "Blog Link"]]]])})
