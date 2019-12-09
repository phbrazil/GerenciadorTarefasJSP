<!doctype html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Gerenciador Tarefas</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    </head>
    <body class='mb-2'>
        <div align='center' class='col-mt-4'>
            <h1 class='text-muted mt-4'>Tarefas</h1>
            <form action="addTarefa" method="post">
                <div class='col-md-5 mb-2'>
                    <input name="responsavel" title="Nome do Responsável" type="text" class="form-control" id="responsavel" placeholder="Nome do Responsável" value="" maxlength ="70" required>
                </div>
                <div class='col-md-5 mb-2'>
                    <input name="nome" title="Nome da Tarefa" type="text" class="form-control" id="artista" placeholder="Nome da Tarefa" value="" maxlength ="70" required>
                </div>
                <div class='col-md-5 mb-2'>
                    <select name = "status" class="custom-select d-block w-100" id="status"  required>
                        <option value='Não iniciada'>Não iniciada</option>
                        <option value='Em andamento'>Em andamento</option>
                        <option value='Concluída'>Concluída</option>
                    </select>
                </div>
                <div class='col-md-5 mb-2'>
                    <input name="datainicio" title="Inicio Tarefa" type="date" class="form-control" id="datainicio" placeholder="Ano da Tarefa" value="" maxlength ="70" required>
                </div>
                <div class='col-md-5 mb-2'>
                    <input name="datafim" title="Fim Tarefa" type="date" class="form-control" id="datafim" placeholder="Fim da Tarefa" value="" maxlength ="70" required>
                </div>
                <div class='col-md-5 mb-2'>
                    <textarea name="descricao" title="Descrição" type="text" class="form-control" id="descricao" placeholder="Descrição da tarefa" value="" maxlength ="200" required></textarea>
                </div>
                <p><input type="submit" value="Enviar" class='btn btn-success' />
                    <input type="reset" value="Limpar"  class='btn btn-danger'/></p>
                <input name="nota" value="${tarefa.nota}" value="0" type="hidden" id="nota">
            </form>
            <a href="/listarTarefas" style='text-decoration: none'>Ver Tarefas</a>

        </div>
    </body>
    
</html>
