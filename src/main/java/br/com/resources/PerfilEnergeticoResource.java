package br.com.resources;

import br.com.model.bo.EmpresaBO;
import br.com.model.bo.PerfilEnergeticoBO;
import br.com.model.beans.PerfilEnergetico;
import jakarta.ws.rs.*;


import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/perfilEnergetico")
public class PerfilEnergeticoResource {


    private EmpresaBO empresaBO = new EmpresaBO();
    private final PerfilEnergeticoBO perfilEnergeticoBO = new PerfilEnergeticoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPerfisEnergeticos() {
        try {
            List<PerfilEnergetico> perfis = perfilEnergeticoBO.listarPerfisEnergeticos();
            return Response.ok(perfis).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar perfis energéticos: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPerfilEnergeticoPorId(@PathParam("id") int id) {
        try {
            PerfilEnergetico perfil = perfilEnergeticoBO.buscarPerfilEnergeticoPorId(id);
            if (perfil == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Perfil Energético não encontrado").build();
            }
            return Response.ok(perfil).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar perfil energético: " + e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionarPerfilEnergetico(PerfilEnergetico perfilEnergetico) {
        try {
            perfilEnergeticoBO.adicionarPerfilEnergetico(perfilEnergetico);
            return Response.status(Response.Status.CREATED).entity(perfilEnergetico).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao adicionar perfil energético: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarPerfilEnergetico(@PathParam("id") int id, PerfilEnergetico perfilEnergetico) {
        try {
            perfilEnergetico.setIdPerfilEnergetico(id);
            perfilEnergeticoBO.atualizarPerfilEnergetico(perfilEnergetico);
            return Response.ok(perfilEnergetico).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao atualizar perfil energético: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPerfilEnergetico(@PathParam("id") int id) {
        try {
            perfilEnergeticoBO.deletarPerfilEnergetico(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao deletar perfil energético: " + e.getMessage()).build();
        }
    }
}
