import { XsRosterUiPage } from './app.po';

describe('xsroster-ui App', function() {
  let page: XsRosterUiPage;

  beforeEach(() => {
    page = new XsRosterUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
