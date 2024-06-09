<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>View Items</title>
        <link href="/static/css/style.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
    </head>
    <body>
    <div class="text-bg-primary p-3">
        <b>Gerenciador de Projetos</b>
    </div>
    <table class="table table-info">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">idgerente</th>
                    <th scope="col">orcamentoTotal</th>
                    <th scope="col">descricao</th>
                    <th scope="col">dataInicio</th>
                    <th scope="col">dataPrevisaoTermino</th>
                    <th scope="col">dataRealTermino</th>
                    <th scope="col">risco</th>
                    <th scope="col">status</th>
                    <th scope="col">deletar projeto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr class="table-light">
                        <td class="table-light">${projeto.id}</td>
                        <td class="table-light">${projeto.nome}</td>
                        <td class="table-light">${projeto.idgerente}</td>
                        <td class="table-light">${projeto.orcamentoTotal}</td>
                        <td class="table-light">${projeto.descricao}</td>
                        <td class="table-light">${projeto.dataInicio}</td>
                        <td class="table-light">${projeto.dataPrevisaoTermino}</td>
                        <td class="table-light">${projeto.dataRealTermino}</td>
                        <td class="table-light">${projeto.risco}</td>
                        <td class="table-light">${projeto.status}</td>
                        <td class="table-light">
                            <form:form action="${pageContext.request.contextPath}/delete-projeto?idprojeto=${projeto.id}" method="post">
                            <c:if test="${projeto.status  != 'iniciado' && projeto.status  != 'em andamento' && projeto.status  != 'encerrado' }">
                                <button type="submit" class="btn btn-danger">Deletar Projeto</button>
                            </c:if>
                        </form:form></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    <form action="${pageContext.request.contextPath}/create-projeto" method="get">
        <button type="submit" class="btn btn-primary">Criar Projeto</button>
    </form>
    <form action="${pageContext.request.contextPath}/view-membros" method="get">
        <button type="submit" class="btn btn-primary">Ver Membros</button>
    </form>
    </body>
</html>