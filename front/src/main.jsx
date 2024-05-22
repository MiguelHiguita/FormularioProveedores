import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import './index.css'
import Formulario from './components/pages/Formulario.jsx'
import Cities from './components/pages/Cities.jsx';

let router = createBrowserRouter([
  {
    path: "/",
    element: <Formulario />
  },
  {
    path: "/Ciudades",
    element: <Cities />
  }
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);
