import getTareas from "./components/getTareas.js";
import AppConfig from "./appConfig.js"

let url = AppConfig.urlBackend;
getTareas(url)