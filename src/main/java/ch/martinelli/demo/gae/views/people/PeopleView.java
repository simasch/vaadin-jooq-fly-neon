package ch.martinelli.demo.gae.views.people;

import ch.martinelli.demo.gae.db.tables.records.PersonRecord;
import ch.martinelli.demo.gae.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.jooq.DSLContext;

import static ch.martinelli.demo.gae.db.tables.Person.PERSON;

@PageTitle("People")
@Route(value = "people", layout = MainLayout.class)
public class PeopleView extends VerticalLayout {

    public PeopleView(DSLContext dslContext) {
        var peopleGrid = new Grid<PersonRecord>();
        peopleGrid.addColumn(PersonRecord::getFirstName).setHeader("First name");
        peopleGrid.addColumn(PersonRecord::getLastName).setHeader("Last name");

        peopleGrid.setItems(query ->
                dslContext.selectFrom(PERSON)
                        .offset(query.getOffset())
                        .limit(query.getLimit())
                        .stream());

        add(peopleGrid);
    }
}
