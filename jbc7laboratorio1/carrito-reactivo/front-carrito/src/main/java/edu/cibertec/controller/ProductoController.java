package edu.cibertec.controller;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.CategoriaService;
import edu.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<ProductoDTO> productos = productoService.listarProductos().collectList().block();
        mav.addObject("listaProductos", productos);
        List<CategoriaDTO> categorias = categoriaService.listarCategorias().collectList().block();
        mav.addObject("listaCategorias", categorias);
        return mav;
    }

    @GetMapping("/index2")
    public ModelAndView index2() {
        ModelAndView mav = new ModelAndView("index");
        IReactiveDataDriverContextVariable listaProductos = new ReactiveDataDriverContextVariable(productoService.listarProductos(), 1);
        mav.addObject("listaProductos", listaProductos);
        IReactiveDataDriverContextVariable listaCategorias = new ReactiveDataDriverContextVariable(categoriaService.listarCategorias(), 1);
        mav.addObject("listaCategorias", listaCategorias);
        return mav;
    }

        
}
