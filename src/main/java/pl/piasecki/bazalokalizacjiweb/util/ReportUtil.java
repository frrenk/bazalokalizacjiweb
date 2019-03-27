package pl.piasecki.bazalokalizacjiweb.util;

import org.springframework.stereotype.Component;

import java.util.List;

// added @Component annotation to prevent IntelliJ showing an error, unnecessary otherwise
@Component
public interface ReportUtil {

    void generatePieChart(String path, List<Object[]> data);
}
