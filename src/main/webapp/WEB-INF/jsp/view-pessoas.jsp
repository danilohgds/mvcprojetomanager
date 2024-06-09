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
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Gerenciador de Projetos</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/view-projetos">Projetos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Pessoas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/view-membros">Membros</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="text-bg-primary p-3">
        <b>Gerenciador de Projetos - Lista de Membros</b>
    </div>
    <table class="table table-info">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">datanascimento</th>
                    <th scope="col">cpf</th>
                    <th scope="col">funcionario</th>
                    <th scope="col">gerente</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pessoas}" var="pessoa">
                    <tr class="table-light">
                        <td class="table-light">${pessoa.id}</td>
                        <td class="table-light">${pessoa.nome}</td>
                        <td class="table-light">${pessoa.datanascimento}</td>
                        <td class="table-light">${pessoa.cpf}</td>
                        <td class="table-light">${pessoa.funcionario}</td>
                        <td class="table-light">${pessoa.gerente}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    <form action="${pageContext.request.contextPath}/create-membro" method="get">
        <button type="submit" class="btn btn-primary">Associar Membro x Projeto</button>
    </form>

    </body>
</html>