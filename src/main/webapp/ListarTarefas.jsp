<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
    <head> 
        <title>Listagem de Tarefas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
    </head>
    <body>
        <c:set var = "result" scope = "session" value = "${result}"/>
        <c:if test = "${result == 'Tarefa iniciada'}">
            <div class='alert alert-success'>Tarefa iniciada
            </div>
        </c:if>  
        <c:if test = "${result == 'Nova tarefa adicionada'}">
            <div class='alert alert-success'>Nova tarefa adicionada
            </div>
        </c:if>  
        <c:if test = "${result == 'Tarefa deletada'}">
            <div class='alert alert-danger'>Tarefa deletada
            </div>
        </c:if>  
        <c:if test = "${result == 'Tarefa atualizada'}">
            <div th:if="${result == 'Tarefa atualizada'}" class='alert alert-success'>Tarefa atualizada com sucesso
            </div>
        </c:if>
        <c:if test = "${result == 'Tarefa concluída'}">
            <div class='alert alert-success'>Tarefa concluída
            </div>
        </c:if>
        <div align="center" class="mb-2 mt-4">
            <table class="table-striped table-bordered table-hover" style="width: 90%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Status</th>
                        <th>Responsável</th>
                        <th>Previsão início</th>
                        <th>Previsão fim</th>
                        <th style='text-align: center'>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="tarefa">
                        <tr>
                            <td>${tarefa.id}</td>
                            <td>${tarefa.nome}</td>
                            <td>${tarefa.descricao}</td>
                            <td>${tarefa.status}</td>
                            <td>${tarefa.responsavel}</td>
                            <td>${tarefa.datainicio}</td>
                            <td>${tarefa.datafim}</td>
                            <td align='center'>
                                <div class="row">
                                    <c:if test = "${tarefa.status == 'Finalizada'}">
                                        <div class='mb-2'>
                                            <span class='text-muted'>
                                                Tarefa finalizada com nota ${tarefa.nota}
                                            </span>
                                        </div>
                                    </c:if>
                                    <c:if test = "${tarefa.status == 'Não iniciada'}">
                                        <div class='mb-2'>
                                            <form action="iniciarTarefa"  method="post">
                                                <input type="hidden" name="id" value="${tarefa.id}" />
                                                <input type="submit" value="Iniciar" class="btn btn-success" />
                                            </form>
                                        </div>
                                    </c:if>
                                    <c:if test = "${tarefa.status != 'Finalizada'}">
                                        <div class='mb-2'>
                                            <form action="deleteTarefa" method="POST">
                                                <input type="hidden" name="id" value="${tarefa.id}" />
                                                <input onclick="return confirm('Quer mesmo deletar?');" type="submit" value="Delete" class="btn btn-danger" />
                                            </form>
                                        </div>
                                    </c:if>
                                    <c:if test = "${tarefa.status != 'Finalizada'}">
                                        <div class='mb-2'>
                                            <button type="button" class="btn mb-1 btn-info text-white" data-toggle="modal" data-target = '#modal${tarefa.id}'>
                                                Editar
                                            </button>
                                        </div>
                                    </c:if>
                                    <c:if test = "${tarefa.status != 'Finalizada'}">
                                        <div class='mb-2'>
                                            <button type="button" class="btn mb-1 btn-success text-white" data-toggle="modal" data-target = '#modalConcluir${tarefa.id}'>
                                                Concluir
                                            </button>
                                        </div>
                                    </c:if>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:forEach items="${lista}" var="tarefa">
                <div  class="modal fade" id = 'modal${tarefa.id}' tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                      aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <!--Content-->
                        <div class="modal-content">
                            <!--Header-->
                            <div class="modal-header light-blue darken-3 white-text">
                                <h4 class="title text-muted text-center">Editar tarefa</h4>                                
                                <button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <!--Body-->
                            <div class="modal-body mb-0">
                                <form action="editTarefa" method="post">
                                    <div class='col-md-12'>
                                        <div class='col-md-5 mb-2'>
                                            <input name="responsavel" value="${tarefa.responsavel}" title="Nome do Responsável" type="text" class="form-control" id="responsavel" maxlength ="70" required>
                                        </div>
                                        <div class='col-md-5 mb-2'>
                                            <input name="nome" value="${tarefa.nome}"  title="Nome da Tarefa" type="text" class="form-control" id="artista" placeholder="Nome da Tarefa" value="" maxlength ="70" required>
                                        </div>
                                        <div class='col-md-5 mb-2'>
                                            <input name="datainicio"  value="${tarefa.datainicio}"  title="Inicio Tarefa" type="date" class="form-control" id="datainicio" placeholder="Ano da Tarefa" value="" maxlength ="70" required>
                                        </div>
                                        <div class='col-md-5 mb-2'>
                                            <input name="datafim"  value="${tarefa.datafim}"  title="Fim Tarefa" type="date" class="form-control" id="datafim" placeholder="Fim da Tarefa" value="" maxlength ="70" required>
                                        </div>
                                        <div class='col-md-5 mb-2'>
                                            <textarea name="descricao" value="${tarefa.descricao}"  th:text="*{descricao}" title="Descrição" type="text" class="form-control" id="descricao" placeholder="Descrição da tarefa" value="" maxlength ="200" required></textarea>
                                        </div>
                                        <input name="id"  value="${tarefa.id}" type="hidden" id="id">
                                        <input name="status"  value="${tarefa.status}" type="hidden" id="status">
                                        <input name="nota"  value="${tarefa.nota}" type="hidden" id="nota">

                                        <p><input type="submit" value="Atualizar" class='btn btn-success' />
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--/.Content-->
                    </div>
                </div>
            </c:forEach>
            <c:forEach items="${lista}" var="tarefa">
                <div class="modal fade" id = 'modalConcluir${tarefa.id}' tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                        <!--Content-->
                        <div class="modal-content">
                            <!--Header-->
                            <div class="modal-header light-blue darken-3 white-text">
                                <h4 class="title text-muted text-center">Finalizar tarefa</h4>                                
                                <button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <!--Body-->
                            <div class="modal-body mb-0">
                                <form action="concluirTarefa" method="post">
                                    <div class='col-md-12'>
                                        <div class='row'>
                                            <div class='col-md-4'>
                                                <span class='text-muted'>Deseja finalizar a tarefa?</span>
                                            </div>
                                            <div class="col-md-4 order-md-1">
                                                <label for="form-autocomplete-1" class="active text-muted"><strong>Selecione a nota</strong></label>
                                                <select  data-toggle="tooltip" autofocus title="" type="text" autocomplete="off" class="input-group form-control" required='true' data-width="auto" data-live-search="true" data-size="5" id="nota" name="nota" maxlength="70">
                                                    <option value='1'>1</option>
                                                    <option value='2'>2</option>
                                                    <option value='3'>3</option>
                                                    <option value='4'>4</option>
                                                    <option value='5'>5</option>
                                                    <option value='6'>6</option>
                                                    <option value='7'>7</option>
                                                    <option value='8'>8</option>
                                                    <option value='9'>9</option>
                                                    <option value='10'>10</option>
                                                </select>
                                            </div>
                                            <input name="id" value="${tarefa.id}" type="hidden" id="id">
                                        </div>
                                    </div>
                                    <div class='col-md-7 mt-2'>
                                        <div class='row'>
                                            <div class='col-md-2 mb-2'>
                                                <div class="form-group col-xs-12">
                                                    <button type="submit" class="btn btn-sm btn-success">Sim</button>
                                                </div>
                                            </div>
                                            <div class='col-md-2 mb-2'>
                                                <div class="form-group col-xs-12">
                                                    <button type="submit" class="btn btn-sm btn-danger" data-dismiss="modal">Não</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!--/.Content-->
                        </div>
                    </div>
                </div>
            </c:forEach>
            
            <div class='col-md-12'>
                <div class='row'>
                    <div class='col-md-5'>
                        <a class='btn btn-lg btn-success mt-4' href="index.jsp" style='text-decoration: none'>Adicionar nova Tarefa</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>