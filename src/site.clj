(def site-name "AC")

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

(def-asset home-page
  {:path "/index.html"
   :type :html
   :data (page "Sur Moi"
               [:div {:class "flex:center items-center align-middle bg-white rounded-lg p-6"}
                [:div {:class "text-center"}
                 [:h2 {:class "text-lg"} "Alex Chojnacki"]
                 [:div {:class "text-blue-500 p-1"} "Machine Learning Engineer"]
                 [:div {:class "text-gray-500 font-mono p-1"} "{my first name}writesprograms@gmail.com"]
                 [:div {:class "text-center align-bottom"} [:i {:class "text-gray-500"} "Help with what? ... I'm gonna need you to be more specific."]]]])})
