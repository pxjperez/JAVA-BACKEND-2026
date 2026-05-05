package edu.cibertec.controller;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.CategoriaService;
import edu.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<ProductoDTO> productos = productoService.listarProductos();
        mav.addObject("listaProductos", productos);
        List<CategoriaDTO> categorias = categoriaService.listarCategorias();
        mav.addObject("listaCategorias", categorias);
        return mav;
    }
}
