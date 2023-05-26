package qr;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import qrLib.QR;

@ApplicationPath("/qrcode")
@Path("")
public class QRCode extends Application {

    @GET
    @Produces("image/png")
    @Path("/{token: .*}")
    public Response generateQRCode(@PathParam("token") String token) throws UnsupportedEncodingException {
        return Response.ok(QR.createQRCodeBufferedImage(URLEncoder.encode(token, "UTF-8"), 512)).build();
    }
}
