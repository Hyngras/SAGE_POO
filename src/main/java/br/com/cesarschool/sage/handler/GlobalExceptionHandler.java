package br.com.cesarschool.sage.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Este método captura qualquer exceção não tratada do tipo Exception.class (a mais genérica).
     * Ele então redireciona o usuário para a nossa página de erro personalizada.
     *
     * @param request A requisição HTTP onde o erro ocorreu.
     * @param ex A exceção que foi lançada.
     * @return um ModelAndView que renderiza a página 'error.html' com os detalhes do erro.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Define o status HTTP da resposta como 500
    public ModelAndView handleAllExceptions(HttpServletRequest request, Exception ex) {
        // Cria um objeto ModelAndView para definir a view e os dados que ela receberá
        ModelAndView modelAndView = new ModelAndView("error"); // Aponta para o arquivo 'error.html'

        // Extrai informações do erro para exibir na página
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        modelAndView.addObject("status", status.value()); // Ex: 500
        modelAndView.addObject("error", status.getReasonPhrase()); // Ex: "Internal Server Error"
        modelAndView.addObject("message", ex.getMessage()); // A mensagem específica da exceção
        modelAndView.addObject("path", request.getRequestURI()); // A URL que causou o erro

        // Opcional: Adiciona o stack trace para depuração (NÃO MOSTRAR EM PRODUÇÃO)
        // Para controlar isso, você pode usar perfis do Spring (ex: 'dev' vs 'prod')
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        modelAndView.addObject("trace", stringWriter.toString());

        return modelAndView;
    }
}