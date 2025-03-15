package MusicShow.ProjetoWeb.Security;

import MusicShow.ProjetoWeb.Dto.MusicoDto;
import MusicShow.ProjetoWeb.Model.MusicoModel;
import MusicShow.ProjetoWeb.Repository.MusicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    @Autowired
    private MusicoRepository musicoRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    // Método para salvar um novo usuário com senha criptografada
    public MusicoModel salvarMusico(MusicoDto musico) {
        musico.setSenha(bCryptPasswordEncoder.encode(musico.getSenha())); // Encripta a senha antes de salvar
        MusicoModel musicoModel = new MusicoModel();
        musicoModel.setLogin(musico.getLogin());
        musicoModel.setSenha(musico.getSenha());
        musicoModel.setNome(musico.getNome());
        return musicoRepository.save(musicoModel);
    }

    // Método para validar a senha ao fazer login
    public boolean verificarSenha(String senhaDigitada, String senhaArmazenada) {
        return bCryptPasswordEncoder.matches(senhaDigitada, senhaArmazenada);
    }

    public MusicoModel buscarMusicoPorLogin(String login) {
        return musicoRepository.findByLogin(login); // Busca o usuário pelo login
    }
}
