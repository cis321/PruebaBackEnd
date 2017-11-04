package co.rappi.backEndSumaMatriz.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.rappi.backEndSumaMatriz.businesses.MatrixBusiness;
import co.rappi.backEndSumaMatriz.exceptions.BusinessException;
import co.rappi.backEndSumaMatriz.exceptions.IException;
import co.rappi.backEndSumaMatriz.exceptions.TechnicalException;
import co.rappi.backEndSumaMatriz.representations.MatrixAndOperationsDTO;

@Path("/matrix")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatrixResource {

	private final MatrixBusiness matrixBusiness;

	public MatrixResource(MatrixBusiness matrixBusiness) {

		this.matrixBusiness = matrixBusiness;
	}

	@POST
	public Response matrixAndOperations(MatrixAndOperationsDTO matrixAndOperationsDTO) {

		try {

			List<String> result = matrixBusiness.calculateResults(matrixAndOperationsDTO);

			return Response.status(Response.Status.OK).entity(result).build();

		} catch (TechnicalException e) {

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();

		} catch (BusinessException e) {

			return Response.status(IException.INTERNAL_BUSINESS_ERROR).entity(e).build();
		}
	}
}
