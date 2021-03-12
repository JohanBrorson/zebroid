package com.github.johanbrorson.zebroid;

import com.github.johanbrorson.zebroid.data.ProductDaoImpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/barcode")
public class BarcodeService {

  @GET
  @Path("get/{code}")
  @Produces(MediaType.TEXT_PLAIN)
  public String getUrl(@PathParam("code") String code) {
    return new ProductDaoImpl().getUrl(code);
  }

  @GET
  @Path("info")
  @Produces(MediaType.TEXT_PLAIN)
  public String getInfo() {
    return new ProductDaoImpl().getInfo();
  }

  @GET
  @Path("random")
  @Produces(MediaType.TEXT_PLAIN)
  public String getRandomUrl() {
    return new ProductDaoImpl().getRandomUrl();
  }

  @GET
  @Path("exists/{code}")
  @Produces(MediaType.TEXT_PLAIN)
  public boolean exists(@PathParam("code") String code) {
    return new ProductDaoImpl().exists(code);
  }
}
