package br.com.resources;

import br.com.model.bo.EmpresaBO;
import br.com.model.beans.Empresa;
import jakarta.ws.rs.*;  // Alterado para javax.ws.rs

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/empresa")
public class EmpresaResource {

    private EmpresaBO empresaBO = new EmpresaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarEmpresas() {
        try {
            List<Empresa> empresas = empresaBO.listarEmpresas();
            return Response.ok(empresas).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar empresas: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEmpresaPorId(@PathParam("id") int id) {
        try {
            Empresa empresa = empresaBO.buscarEmpresaPorId(id);
            if (empresa == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Empresa não encontrada").build();
            }
            return Response.ok(empresa).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar empresa: " + e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionarEmpresa(Empresa empresa) {
        try {
            empresaBO.adicionarEmpresa(empresa);
            return Response.status(Response.Status.CREATED).entity(empresa).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao adicionar empresa: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarEmpresa(@PathParam("id") int id, Empresa empresa) {
        try {
            empresa.setIdEmpresa(id);
            empresaBO.atualizarEmpresa(empresa);
            return Response.ok(empresa).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao atualizar empresa: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarEmpresa(@PathParam("id") int id) {
        try {
            empresaBO.deletarEmpresa(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao deletar empresa: " + e.getMessage()).build();
        }
    }
}
