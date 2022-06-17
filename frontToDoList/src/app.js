import getTareas from "./components/getTareas.js";
import AppConfig from "./appConfig.js"
import createTarea from "./components/createTarea.js";

const d = document;
const $form = d.getElementById("formCreateTarea")

let url = AppConfig.urlBackend;
getTareas(url)

d.addEventListener('submit', async (e) => {
    e.preventDefault();
    console.log(e.target.nombreTarea.value);
    if (e.target === $form) {
        e.preventDefault();
        await createTarea(url, e.target.nombreTarea.value);
    }
})