package br.com.exemplo.exemplo.domain.livros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livros, Long> {
}
