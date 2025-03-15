package MusicShow.ProjetoWeb.Controller;

import MusicShow.ProjetoWeb.Dto.LoginRequestDto;
import MusicShow.ProjetoWeb.Dto.MusicoDto;
import MusicShow.ProjetoWeb.Model.MusicoModel;
import MusicShow.ProjetoWeb.Security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class AuthController {


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        // Busca o usuário pelo login
        MusicoModel musico = customUserDetailsService.buscarMusicoPorLogin(loginRequest.getNome());

        // Verifica se o usuário existe
        if (musico == null) {
            return ResponseEntity.status(401).body("Usuário não encontrado.");
        }

        // Verifica se a senha fornecida corresponde à senha armazenada (criptografada)
        if (customUserDetailsService.verificarSenha(loginRequest.getSenha(), musico.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }

    @PostMapping("/cadastro")
    public MusicoModel cadastrar(@RequestBody MusicoDto musico) {
        return customUserDetailsService.salvarMusico(musico);
    }
}