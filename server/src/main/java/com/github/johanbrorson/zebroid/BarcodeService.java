package com.github.johanbrorson.zebroid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.johanbrorson.zebroid.data.ProductDaoImpl;

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
