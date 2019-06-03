package br.ufc.web._final.service;

import br.ufc.web._final.model.Prato;
import br.ufc.web._final.repository.PratoRepository;
import br.ufc.web._final.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    public void save(Prato prato, @RequestParam(value = "imagem") MultipartFile imagem) {
        String caminho = "images/" + prato.getNome() + ".png";
        ImageUtil.saveImage(caminho, imagem);
        pratoRepository.save(prato);
    }

    public List<Prato> listPratos() { return pratoRepository.findAll(); }

    public void delete(Long id) {
        String caminho = "images/" + serchById(id).getNome() + ".png";
        ImageUtil.deleteImage(caminho);
        pratoRepository.deleteById(id);
    }

    public Prato serchById(Long id) { return pratoRepository.getOne(id); }
}
