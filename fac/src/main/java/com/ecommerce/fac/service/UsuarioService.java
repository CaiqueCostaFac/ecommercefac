package com.ecommerce.fac.service;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.fac.model.Usuario;
import com.ecommerce.fac.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Busca um usuário pelo email
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Valida a senha digitada com a senha armazenada
    public boolean validarSenha(String senhaDigitada, String senhaArmazenada) {
        return passwordEncoder.matches(senhaDigitada, senhaArmazenada);
    }

    // Salva um usuário com a senha criptografada
    public Usuario salvarSenhaUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    // Lista todos os usuários
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Busca um usuário pelo ID
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Salva um usuário
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Busca um usuário pelo email
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Verifica se um email já está cadastrado
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    // Valida o CPF
    public boolean validarCPF(String cpf) {
        // Implementação simples de validação de CPF
        String cpfPattern = "^[0-9]{11}$";

        // Verifica se o formato do CPF é válido
        if (!Pattern.matches(cpfPattern, cpf)) {
            return false;
        }

        // Verifica se o CPF já está cadastrado no banco de dados
        return !usuarioRepository.existsByCpf(cpf);
    }
}
