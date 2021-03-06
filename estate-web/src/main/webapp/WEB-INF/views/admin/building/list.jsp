<%--
  Created by IntelliJ IDEA.
  User: vothanhtai
  Date: 3/5/19
  Time: 22:35
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="searchUrl" value="/admin/building/list"></c:url>
<c:url var="editUrl" value="/admin/building/edit"></c:url>
<c:url var="submitFormUrl" value="/admin/building/"></c:url>
<c:url var="assignmentStaffApi" value="/api/assignment/staff"></c:url>
<c:url var="wardApi" value="/api/ward"></c:url>
<html>
<head>
    <title>
        <fmt:message bundle="${lang}" key="building.page.title"/>
    </title>
    <content tag="specific_css">
        <link rel="stylesheet"
              href="<c:url value='/template/admin/vendor/bootstrap-multiselect/bootstrap-multiselect.css'/>"/>
    </content>
</head>
<body>
<section class="panel panel-featured">
    <header class="panel-heading">
        <h2 class="panel-title">
            <fmt:message bundle="${lang}" key="search"/>
        </h2>
    </header>
    <div class="panel-body">
        <form:form action="" method="get" modelAttribute="command">
            <div class="row">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.name"/>
                        </label>
                        <form:input path="pojo.name" cssClass="form-control"/>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.buildingArea.from"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.buildingAreaFrom" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.buildingArea.to"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.buildingAreaTo" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.district"/>
                        </label>
                        <div>
                            <form:select path="pojo.districtId" data-plugin-selectTwo="true"
                                         cssClass="form-control" id="district-select">
                                <form:option value="0"><fmt:message bundle='${lang}' key='select.all'/></form:option>
                                <form:options items="${command.districtDtoList}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.ward"/>
                        </label>
                        <div>
                            <form:select path="pojo.wardId" data-plugin-selectTwo="true" disabled="true"
                                         cssClass="form-control" id="ward-select">
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.street"/>
                        </label>
                        <div>
                            <form:input path="pojo.street" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.managerName"/>
                        </label>
                        <div>
                            <form:input path="pojo.managerName" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.managerPhone"/>
                        </label>
                        <div>
                            <form:input path="pojo.managerPhone" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.staff"/>
                        </label>
                        <div class="myMultiSelect">
                            <form:select path="pojo.staffArray" data-plugin-multiselect="true" multiple="true"
                                         cssClass="form-control" items="${command.staffDtoList}" itemValue="id"
                                         itemLabel="fullName">
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.rentArea.from"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.rentAreaFrom" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.rentArea.to"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.rentAreaTo" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.rentalCost.from"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.rentalCostFrom" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.rentalCost.to"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.rentalCostTo" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.numberOfBasement"/>
                        </label>
                        <div>
                            <form:input type="number" path="pojo.numberOfBasement" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.direction"/>
                        </label>
                        <div>
                            <form:input path="pojo.direction" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.level"/>
                        </label>
                        <div>
                            <form:input path="pojo.level" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>
                            <fmt:message bundle="${lang}" key="building.type"/>
                        </label>
                        <div class="myMultiSelect">
                            <form:select path="pojo.typeArray" data-plugin-multiselect="true" multiple="true"
                                         cssClass="form-control" items="${command.buildingTypeArray}"
                                         itemLabel="typeName">
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="form-group text-center">
                <button class="mb-xs btn mr-xs btn-info" id="submitButton">
                    <fmt:message bundle="${lang}" key="search"/>
                    <i class="fa fa-search"></i>
                </button>
                <a href="<c:url value="/admin/building/list"/>" type="reset" class="mb-xs btn btn-default">
                    <fmt:message bundle="${lang}" key="reset"/>
                </a>
            </div>
        </form:form>
    </div>
</section>
<section class="panel panel-featured">
    <header class="panel-heading">
        <h2 class="panel-title">
            <fmt:message bundle="${lang}" key="building.list"/>
        </h2>
    </header>
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-6">
                <div class="mb-md">
                    <a href="${editUrl}" class="btn btn-primary">
                        <fmt:message bundle="${lang}" key="insert"/>
                        <i class="fa fa-plus"></i></a>
                    <button class="btn btn-danger" id="btnDeleteAll" disabled>
                        <fmt:message bundle="${lang}" key="delete"/>
                        <i class="fa fa-trash-o"></i></button>
                </div>
            </div>
        </div>
        <form id="buildingDeleteForm">
            <table class="table table-bordered table-striped mb-none" id="building-table">
                <thead>
                <tr>
                    <th class="nosort">
                        <div class="checkbox-custom checkbox-default">
                            <label for="chkCheckAll"></label><input type="checkbox" id="chkCheckAll">
                            <label></label>
                        </div>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.date"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.name.table"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.address"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.managerName.table"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.managerPhone.table"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.buildingArea.table"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.rentalArea.table"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.rentalCost"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.serviceCost"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="building.commissionCost"/>
                    </th>
                    <th>
                        <fmt:message bundle="${lang}" key="action"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="districtDto" items="${command.listResult}">
                    <tr>
                        <td>
                            <div class="checkbox-custom checkbox-default">
                                <input type="checkbox" class="checkbox-item" name="checkList" value="${districtDto.id}">
                                <label></label>
                            </div>
                        </td>
                        <td>
                            <fmt:formatDate value="${districtDto.createdDate}" pattern="dd-MM-yyyy"/>
                        </td>
                        <td>${districtDto.name}</td>
                        <td>${districtDto.fullAddress}</td>
                        <td>${districtDto.managerName}</td>
                        <td>${districtDto.managerPhone}</td>
                        <td>${districtDto.buildingArea}</td>
                        <td>${fn:join(districtDto.rentalAreaArray, ', ')}</td>
                        <td>
                            <fmt:formatNumber type="number" maxFractionDigits="3" value="${districtDto.rentalCost}"/>
                        </td>
                        <td>${districtDto.serviceCost}</td>
                        <td>${districtDto.commissionCost}</td>
                        <td class="actions">
                            <a href="#" class="btn-assignment" data-building-id="${districtDto.id}"><i
                                    class="fa fa-tasks"></i></a>
                            <a href="<c:url value='${editUrl}/${districtDto.id}'/>" class="on-default edit-row"><i
                                    class="fa fa-pencil"></i></a>
                            <a href="#" class=""><i class="fa fa-trash-o"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</section>

<content tag="specific_html">
    <div id="delete-dialog" class="zoom-anim-dialog modal-block mfp-hide">
        <section class="panel panel-featured">
            <header class="panel-heading">
                <h2 class="panel-title">
                    <fmt:message bundle="${lang}" key="delete.ask.title"/>
                </h2>
            </header>
            <div class="panel-body">
                <div class="modal-wrapper">
                    <div class="modal-text">
                        <p>
                            <fmt:message bundle="${lang}" key="delete.ask.text"/>
                        </p>
                    </div>
                </div>
            </div>
            <footer class="panel-footer">
                <div class="row">
                    <div class="col-md-12 text-right">
                        <button id="confirmDelete" class="btn btn-primary">
                            <fmt:message bundle="${lang}" key="confirm"/>
                        </button>
                        <button class="modal-dismiss btn btn-default">
                            <fmt:message bundle="${lang}" key="cancel"/>
                        </button>
                    </div>
                </div>
            </footer>
        </section>
    </div>

    <div id="assignment-dialog" class="zoom-anim-dialog modal-block mfp-hide">
        <section class="panel panel-featured">
            <header class="panel-heading">
                <h2 class="panel-title">
                    <fmt:message bundle="${lang}" key="assignment.staff.list"/>
                </h2>
            </header>
            <div class="panel-body">
                <div class="modal-wrapper">
                    <div class="modal-text">
                        <form id="assignmentForm">
                            <input type="hidden" name="buildingId" id="buildingIdHiddenInput">
                            <table class="table table-bordered table-striped mb-none" id="assignment-table">
                                <thead>
                                <tr>
                                    <th>
                                        <fmt:message bundle="${lang}" key="staff.assign"/>
                                    </th>
                                    <th>
                                        <fmt:message bundle="${lang}" key="staff.fullName"/>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <footer class="panel-footer">
                <div class="row">
                    <div class="col-md-12 text-right">
                        <button id="confirmAssign" class="btn btn-primary">
                            <fmt:message bundle="${lang}" key="save"/>
                        </button>
                        <button class="modal-dismiss btn btn-default">
                            <fmt:message bundle="${lang}" key="cancel"/>
                        </button>
                    </div>
                </div>
            </footer>
        </section>
    </div>
</content>
<content tag="specific_script">
    <script src="<c:url value='/template/admin/vendor/bootstrap-multiselect/bootstrap-multiselect.js'/>"></script>
</content>
<content tag="local_script">
    <script type="application/javascript">
        $(document).ready(function () {
            $('#building-table').DataTable({
                // tai edited here
                paging: false,
                info: false,
                bAutoWidth: false,
                order: [], //Initial no order.
                aaSorting: [],
                aoColumnDefs: [{
                    bSortable: false,
                    aTargets: [0, -1]
                },
                    {
                        aTargets: [0, -1],
                        className: "align-center"
                    }]
            });

            addEventAssignmentButton();
            addEventDeleteButton();
            processDistrictChange();

            //    show pnotify in session storage
            if (sessionStorage.pNotify) {
                new PNotify(JSON.parse(sessionStorage.getItem("pNotify")));
                sessionStorage.removeItem("pNotify");
            }
        });

        function processDistrictChange() {
            $("#district-select").change(function () {
                if ($(this).val() != 0) {
                    $.ajax({
                        type: 'GET',
                        url: '${wardApi}?districtId=' + $(this).val(),
                        dataType: 'json',
                        success: function (data) {
                            $("#ward-select").empty();
                            $("#ward-select").append(new Option('<fmt:message bundle="${lang}" key="select.all"/>', 0, false, false));

                            data.forEach(function (ward) {
                                var newOption = new Option(ward.name, ward.id, false, false);
                                $("#ward-select").append(newOption);

                                if (ward.id == '${param['search.wardId']}') {
                                    $('#ward-select').val(${param['search.wardId']}).trigger("change");
                                }
                            });
                            $("#ward-select").trigger('change');
                            $("#ward-select").select2("enable", true);
                        }
                    });
                } else {
                    $("#ward-select").empty().trigger('change');
                    $("#ward-select").select2('data', null);
                    $("#ward-select").select2("enable", false);

                }
            });

            if ($("#district-select").val() != 0) {
                $("#district-select").trigger('change');
            }
        }

        function addEventAssignmentButton() {
            $(".btn-assignment").click(function (e) {
                e.preventDefault();

                var buildingId = $(this).data("building-id");
                fillAssignmentStaffList(buildingId);
                $("#buildingIdHiddenInput").val(buildingId);

                $.magnificPopup.open({
                    items: {
                        src: '#assignment-dialog',
                        type: 'inline'
                    },
                    preloader: false,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in',
                    modal: true,
                    callbacks: {
                        open: function () {
                            $('#confirmAssign').on('click', function (e) {
                                e.preventDefault();
                                $.magnificPopup.close();

                                var data = $("#assignmentForm").serializeObject();
                                saveAssignmentStaff(data);
                            });
                        },
                        close: function () {
                            $('#confirmAssign').off('click');
                        }
                    }
                });
            })
        }

        function fillAssignmentStaffList(buildingId) {
            $.ajax({
                type: 'GET',
                url: '${assignmentStaffApi}?buildingId=' + buildingId,
                dataType: 'json',
                success: function (result) {
                    renderAssignmentTable(result);
                }
            });
        }

        function renderAssignmentTable(data) {
            var tbody = '';
            data.forEach(function (staff) {
                var row = '<tr><td>\n' +
                    '<div class="checkbox-custom checkbox-default">\n' +
                    '<input type="checkbox" name="checkList" value="' + staff.id + '" ' + staff.checked + '><label></label></div></td>\n' +
                    '<td>' + staff.fullName + '</td></tr>';
                tbody += row;
            });

            $("#assignment-table tbody").html(tbody);
        }

        function saveAssignmentStaff(data) {
            $.ajax({
                type: 'POST',
                url: '${assignmentStaffApi}',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    new PNotify({
                        title: '<fmt:message bundle="${lang}" key="assignment.success"/>',
                        text: '<fmt:message bundle="${lang}" key="assignment.success.text"/>',
                        type: 'success'
                    });
                },
                error: function (error) {
                    new PNotify({
                        title: '<fmt:message bundle="${lang}" key="assignment.error"/>',
                        text: '<fmt:message bundle="${lang}" key="error"/>',
                        type: 'error'
                    });
                }
            });
        }

        function addEventDeleteButton() {
            $('#btnDeleteAll').on('click', function (e) {
                e.preventDefault();
                $.magnificPopup.open({
                    items: {
                        src: '#delete-dialog',
                        type: 'inline'
                    },
                    preloader: false,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in',
                    modal: true,
                    callbacks: {
                        open: function () {
                            $('#confirmDelete').on('click', function (e) {
                                e.preventDefault();
                                $.magnificPopup.close();

                                var data = $("#buildingDeleteForm").serializeObject();
                                deleteBuilding(data);
                            });
                        },
                        close: function () {
                            $('#confirmDelete').off('click');
                        }
                    }
                });
            })
        }

        function deleteBuilding(data) {
            console.log(JSON.stringify(data))
            $.ajax({
                type: 'DELETE',
                url: '${submitFormUrl}',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    var pnotify = {
                        title: '<fmt:message bundle="${lang}" key="delete.success"/>',
                        text: '<fmt:message bundle="${lang}" key="building.delete.success"/>',
                        type: 'success'
                    };
                    sessionStorage.setItem("pNotify", JSON.stringify(pnotify));

                    window.location.href = '${submitFormUrl}list';
                },
                error: function (error) {
                    new PNotify({
                        title: '<fmt:message bundle="${lang}" key="delete.error"/>',
                        text: '<fmt:message bundle="${lang}" key="error"/>',
                        type: 'error'
                    });
                }
            });
        }
    </script>
</content>
</body>
</html>