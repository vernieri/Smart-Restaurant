using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC_GerenciadoDeConteudo.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        public ActionResult Cardapio() {
            ViewBag.Message = "Cardapio Page.";

            return View();
        }

        public ActionResult Galeria() {
            ViewBag.Message = "Galeria Page.";
            return View();
        }
        public ActionResult Formulario()
        {
            //ViewPage = "Form";
            return View("Formulario");
        }        
    }
}
